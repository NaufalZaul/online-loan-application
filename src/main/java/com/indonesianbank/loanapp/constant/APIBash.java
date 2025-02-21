package com.indonesianbank.loanapp.constant;

public class APIBash {
    /**
     * DOCUMENTATION API
     */

    // AUTH DOCUMENTATION
    public static final String AUTH_PATH = "/api/auth";
    public static final String REGISTER_PATH = "/signup";
    public static final String LOGIN_PATH = "/signin";

    // USER DOCUMENTATION
    public static final String USER_BY_ID_PATH = "/api/users/{id}";

    // CUSTOMER DOCUMENTATION
    public static final String CUSTOMER_PATH = "/api/customers";
    public static final String CUSTOMER_BY_ID_PATH = "/{id}";

    // INSTALMENT TYPE DOCUMENTATION
    public static final String INSTALMENT_TYPE_PATH = "/api/instalment-types";
    public static final String INSTALMENT_TYPE_BY_ID_PATH = "/{id}";

    // LOAN DOCUMENTATION
    public static final String LOAN_PATH = "/api/loan-types";
    public static final String LOAN_BY_ID_PATH = "/{id}";

    // TRANSACTION DOCUMENTATION
    public static final String TRANSACTION_PATH = "/api/transactions";
    public static final String TRANSACTION_BY_ID_PATH = "/{id}";
    public static final String APPROVE_TRANSACTION_PATH = "/{adminId}/approve";
    public static final String PAY_INSTALMENT_PATH = "/{trxId}/pay";

    /**
     * DOCUMENTATION MESSAGE API
     */

    // LOAN DOCUMENTATION (message)
    public static final String CREATE_MESSAGE = "Loan type created successfully";
    public static final String FOUND_MESSAGE = "Loan type data has been found";
    public static final String UPDATE_MESSAGE = "Loan type updated successfully";
    public static final String DELETE_MESSAGE = "Loan type deleted successfully";
}
