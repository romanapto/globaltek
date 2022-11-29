curl -XPOST localhost:9200/sc-role/_create/INVENTORY_USER -H 'Content-Type: application/json' -d '
{
          "roleName": "INVENTORY_USER",
          "id": "INVENTORY_USER",
          "description": "Has inventory right"
        }'      
        
curl -XPOST localhost:9200/sc-role/_create/ORGANIZATION_ADMIN_USER -H 'Content-Type: application/json' -d '
{
          "roleName": "ORGANIZATION_ADMIN_USER",
          "id": "ORGANIZATION_ADMIN_USER",
          "description": "Organization Admin User - Has no admin rights"
        }'
        
curl -XPOST localhost:9200/sc-role/_create/ORGANIZATION_STANDARD_USER -H 'Content-Type: application/json' -d '
{
          "roleName": "ORGANIZATION_STANDARD_USER",
          "id": "ORGANIZATION_STANDARD_USER",
          "description": "Organization Standard User - Has no admin rights"
        }'
        
curl -XPOST localhost:9200/sc-role/_create/REPORTS_USER -H 'Content-Type: application/json' -d '
{
          "roleName": "REPORTS_USER",
          "id": "REPORTS_USER",
          "description": "Has report right"
        }'
        
curl -XPOST localhost:9200/sc-role/_create/STANDARD_USER -H 'Content-Type: application/json' -d '
{
          "roleName": "STANDARD_USER",
          "id": "STANDARD_USER",
          "description": "SuperAdmin Standard User - Has no admin rights"
        }'
        
curl -XPOST localhost:9200/sc-role/_create/ORDERS_USER -H 'Content-Type: application/json' -d '
{          
          "roleName": "ORDERS_USER",
          "id": "ORDERS_USER",
          "description": "Has order right"
        }'
        
curl -XPOST localhost:9200/sc-role/_create/ADMIN_USER -H 'Content-Type: application/json' -d '
{
          "roleName": "ADMIN_USER",
          "id": "ADMIN_USER",
          "description": "SuperAdmin Admin User - Has permission to perform admin tasks"
        }'
        
curl -XPOST localhost:9200/sc-role/_create/CATALOG_USER -H 'Content-Type: application/json' -d '
{
          "roleName": "CATALOG_USER",
          "id": "CATALOG_USER",
          "description": "Has catalog right"
        }'
        
curl -XPOST localhost:9200/sc-role/_create/CARRIERS_USER -H 'Content-Type: application/json' -d '
{
          "roleName": "CARRIERS_USER",
          "id": "CARRIERS_USER",
          "description": "Has carrier right"
        }'
        
curl -XPOST localhost:9200/sc-seller/_create/demosellercenter -H 'Content-Type: application/json' -d '
{
          "terms": "Terminos y condiciones",
          "description": "Seller de test",
          "accountName": "demosellercenter",
          "imageFile": null,
          "id": "demosellercenter",
          "name": "demosellercenter"
        }'
        
curl -XPOST localhost:9200/sc-user/_create/1 -H 'Content-Type: application/json' -d '
{
          "organizations": [
            {
              "accountName": "demosellercenter",
              "id": "demosellercenter",
              "name": "demosellercenter"
            }
          ],
          "firstName": "Admin",
          "roles": [
            {
              "roleName": "ADMIN_USER",
              "id": "ADMIN_USER",
              "description": "SuperAdmin Admin User - Has permission to perform admin tasks"
            },
            {
              "roleName": "REPORTS_USER",
              "id": "REPORTS_USER",
              "description": "Has report right"
            },
            {
              "roleName": "CARRIERS_USER",
              "id": "CARRIERS_USER",
              "description": "Has carrier right"
            },
            {
              "roleName": "INVENTORY_USER",
              "id": "INVENTORY_USER",
              "description": "Has inventory right"
            },
            {
              "roleName": "ORDERS_USER",
              "id": "ORDERS_USER",
              "description": "Has order right"
            },
            {
              "roleName": "CATALOG_USER",
              "id": "CATALOG_USER",
              "description": "Has catalog right"
            }
          ],
          "lastName": "Admin",
          "email": "admin@admin.com",
          "password": "{bcrypt}$2a$10$DelzNRFIfF.QPtMouUsGX.ZyJykyGbGsVI3Q40Ms6i7rzy0NO3B6e",
          "id": "1"
        }'
