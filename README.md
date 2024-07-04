# **Banking Backend Project**

## **Project Description**
This project is a backend system for managing banking operations, developed using the Spring Framework. It provides functionality to create, retrieve, update, and delete bank accounts, as well as manage transactions such as deposits and withdrawals. The project uses MySQL for data storage and Postman for API testing.

## **Features**
- **Create Account**: Add a new account.
- **Get Account by ID**: Retrieve account details using the account ID.
- **Deposit**: Deposit money into an account.
- **Withdraw**: Withdraw money from an account.
- **Get All Accounts**: Retrieve details of all accounts.
- **Delete Account**: Delete an account by its ID.

## **Technologies Used**
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL** (for data storage)
- **Postman** (for API testing)
- **IntelliJ IDEA** (for development)

## **Installation Instructions**
1. **Clone the Repository**:
    ```bash
    git clone <repository-url>
    cd banking-backend-project
    ```
2. **Set Up Database**:
    - Ensure MySQL is installed and running.
    - Create a new database for the project.
    - Update the database configuration in the `application.properties` file.

3. **Build the Project**:
    ```bash
    ./mvnw clean install
    ```

4. **Run the Project**:
    ```bash
    ./mvnw spring-boot:run
    ```

## **Usage Instructions**
1. **Create an Account**:
    - **Endpoint**: `POST /accounts`
    - **Body**:
      ```json
      {
          "accountNumber": "123456789",
          "accountHolderName": "John Doe",
          "balance": 1000.00
      }
      ```

2. **Get Account by ID**:
    - **Endpoint**: `GET /accounts/{id}`

3. **Deposit Money**:
    - **Endpoint**: `PUT /accounts/{id}/deposit`
    - **Body**:
      ```json
      {
          "amount": 500.00
      }
      ```

4. **Withdraw Money**:
    - **Endpoint**: `PUT /accounts/{id}/withdraw`
    - **Body**:
      ```json
      {
          "amount": 200.00
      }
      ```

5. **Get All Accounts**:
    - **Endpoint**: `GET /accounts`

6. **Delete Account**:
    - **Endpoint**: `DELETE /accounts/{id}`

## **Class Overview**
### `AccountService` (Service Interface)
- Defines the contract for account-related operations.
- Methods:
  - `createAccount(AccountDto accountDto)`: Creates a new account.
  - `getAccountById(Long id)`: Retrieves an account by its ID.
  - `deposite(Long id, double amount)`: Deposits money into an account.
  - `withdraw(Long id, double amount)`: Withdraws money from an account.
  - `getAllAccounts()`: Retrieves all accounts.
  - `deleteAccount(Long id)`: Deletes an account.

## **License**
This project is licensed under the MIT License. See the LICENSE file for details.

## **Acknowledgements**
- Thanks to the Spring community for their comprehensive documentation and support.
- Thanks to the developers of IntelliJ IDEA for providing an excellent development environment.
- Special thanks to the MySQL team for providing a robust database solution.
