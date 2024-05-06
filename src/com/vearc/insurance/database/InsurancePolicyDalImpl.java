package com.vearc.insurance.database;

import com.vearc.insurance.bean.InsurancePolicy;
import com.vearc.insurance.bean.PolicyStatus;
import com.vearc.insurance.generators.CreatedDateGenerator;
import com.vearc.insurance.generators.IdGenerator;
import com.vearc.insurance.generators.ModifiedDateGenerator;
import com.vearc.insurance.generators.PolicyAttributeGenerator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/*
* Database layer implementation class for read and write operations of {@code InsurancePolicy}
* */
public class InsurancePolicyDalImpl implements InsurancePolicyDal {

    private static final List<PolicyAttributeGenerator> generators = new ArrayList<>();

    static {
        generators.add(new IdGenerator());
        generators.add(new CreatedDateGenerator());
        generators.add(new ModifiedDateGenerator());
    }

    @Override
    public InsurancePolicy getPolicyByID(int id) {
        AtomicReference<InsurancePolicy> get = new AtomicReference<>();
        getDbConnection().ifPresent(connection -> {
            try(Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(QueryHelper.getSelectPolicyQueryUsingId(id));
                get.set(transformResultSet(resultSet));
            } catch (SQLException se) {
                se.printStackTrace();
            }
        });
        return get.get();
    }

    @Override
    public List<InsurancePolicy> getPoliciesByName(String name) {
        List<InsurancePolicy> policies = new ArrayList<>();
        getDbConnection().ifPresent(connection -> {
            try(Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(QueryHelper.getSelectQueryUsingName(name));
                while (resultSet.next()) {
                    policies.add(transformResultSet(resultSet));
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        });
        return policies;
    }

    @Override
    public InsurancePolicy save(InsurancePolicy policy) {
        AtomicReference<InsurancePolicy> saved = new AtomicReference<>();
        generators.forEach(generator -> generator.generateAttributeValue(policy));
        getDbConnection().ifPresent(connection -> {
            try(Statement stmt = connection.createStatement()) {
                ResultSet resultSet = stmt.executeQuery(QueryHelper.getSaveQuery(policy));
                saved.set(transformResultSet(resultSet));
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        });
        return saved.get();
    }

    @Override
    public InsurancePolicy update(InsurancePolicy policy) {
        AtomicReference<InsurancePolicy> updated = new AtomicReference<>();
        generators.forEach(generator -> generator.generateAttributeValue(policy));
        getDbConnection().ifPresent(connection -> {
            try(Statement stmt = connection.createStatement()) {
                ResultSet resultSet = stmt.executeQuery(QueryHelper.getUpdateQuery(policy));
                updated.set(transformResultSet(resultSet));
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        });
        return updated.get();
    }

    private Optional<Connection> getDbConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dev", "postgres", "postgres");
        } catch (SQLException se) {
            se.printStackTrace();
            throw new RuntimeException("Failed to get db connection");
        }
        return Optional.ofNullable(connection);
    }

    private InsurancePolicy transformResultSet(ResultSet resultSet) {
        InsurancePolicy policy = new InsurancePolicy();
        try {
            policy.setName(resultSet.getString(QueryHelper.TableColumns.name));
            policy.setStatus(resultSet.getObject(QueryHelper.TableColumns.status, PolicyStatus.class));
            policy.setId(resultSet.getInt(QueryHelper.TableColumns.id));
            policy.setCreatedDate(resultSet.getDate(QueryHelper.TableColumns.createdDate));
            policy.setModifiedDate(resultSet.getDate(QueryHelper.TableColumns.modifiedDate));
            policy.setCoverageBeginDate(resultSet.getDate(QueryHelper.TableColumns.coverageBegin));
            policy.setCoverageEndDate(resultSet.getDate(QueryHelper.TableColumns.coverageEnd));
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return policy;
    }

}
