# Batı-Cuisine Application

Batı-Cuisine is a Java-based command-line application designed for constructors to efficiently manage renovation and construction projects. It provides a user-friendly interface for tracking project details, costs, and client information. The application allows seamless management of labor, materials, and the generation of transparent quotes for clients.

## Features

### Project Management
- Design and manage renovation or construction projects.
- Track all relevant project details including costs.

### Client Relationship
- Link jobs to individual clients for easy referencing of billing and quotations.

### Material Tracking
- Add materials to projects with unit cost, quantity, and transportation details.
- Accurate estimation of material costs.

### Labor Management
- Log personnel work hours with hourly rates and track performance.
- Calculate total labor costs based on logged hours.

### Material Cost Calculation
- Manage materials and manpower costs based on project requirements.
- Costs are adjusted based on the required quality and expertise.

### Generation of Quotes
- Generate detailed quotes based on estimated costs for materials, labor, and equipment.
- Provide clients with transparent and detailed cost breakdowns.

### Manage Dates
- Set issue dates and validity periods for quotes.
- Inform clients of offer duration and expiration.

### Client Acceptance
- Clients can accept or decline quotes.
- Manage project continuation based on client confirmations.

### Customer Information Management
- Store and manage customer details for follow-ups and billing purposes.

### Client Differentiation
- Differentiate between professional and individual clients.
- Apply different discounts or conditions based on client type.

### Comprehensive Cost Overview
- Calculate overall project costs, including materials, labor, equipment, and taxes.
- Derive a complete financial overview for each project.

### Adjustable Cost Parameters
- Managers can adjust costs based on material quality and worker productivity.
- Ensure accurate final estimates.

### Tax Visibility
- Display taxes, including VAT and other charges, in final estimates.

## Application Structure

- **Views (Root View)**: 
  - Contains the console-based user interface that interacts with the user.
  
- **Model (Entities)**: 
  - Contains the core entity classes representing the application's data, such as `Client`, `Project`, `Material`, `Labor`, etc.
  
- **Repository (Interfaces)**: 
  - Provides interfaces for Data Access Objects (DAO) which handle CRUD (Create, Read, Update, Delete) operations on entities like clients, projects, and materials.
  
- **RepositoryImpl (Implementations)**: 
  - Implements the repository interfaces, ensuring interaction with the underlying database or storage mechanism.
  
- **Services (Interfaces)**: 
  - Defines business logic interfaces that provide high-level operations for managing entities like clients, projects, labor, and materials.
  
- **ServiceImpl (Implementations)**: 
  - Implements the service interfaces, coordinating between the repository layer and the application logic to perform business tasks.

## Environnement Java
- **Java JDK 8** ou version supérieure.
- **PostgreSQL** Database used to store data.

### Prerequisites

Ensure you have the following installed on your machine:

- **Java 8** or later
- **PostgreSQL** database with the necessary tables and schema (setup instructions below)
- **JDBC Driver** for PostgreSQL
- A console or terminal to run the application

### Installation

1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/JavaAura/Med_Hachami_S1_B3_Bati-Cuisine
   cd Med_Hachami_S1_B3_Bati-Cuisine

2. Create a PostgreSQL database and run the SQL script to set up the necessary tables:
    ```bash

3. Update the `.env` file with your database connection details.

### Running the APP
To run the application, execute the following command:
```bash
     ./run.sh  
```
