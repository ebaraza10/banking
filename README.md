# Application to sufface transactions

# Technologies used:
1. Java(Spring boot) - For the API
2. React JS - For the fronntend
3. Mongo DB - For the database
4. Nginx - Web server serving the frontend and acting as a proxy for the API.
5. Docker - to conteneriser the API, frontend and database services.

 # How to setup and run:
 1. Install docker: https://docs.docker.com/engine/install/
 2. Install docker-compose: https://docs.docker.com/compose/install/
 3. Navigate to the project directory.
 4. Rename the .env_template file to be .env
 5. Edit the configurations in .env to match your credentials and paths
 6. Rename the application_template.properties founnd in docker-dependency-services/api to be docker-dependency-services/api/application.properties
 7. Edit the configurations in docker-dependency-services/api/application.properties to match your credentials.
 8. Fire up the containers in detatched mode: docker-compose -f docker-compose-prod.yml up -d
 