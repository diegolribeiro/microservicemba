# base image
FROM node:10 as node

# Preparing working environment.
WORKDIR /app

# Installing dependencies.
COPY . .
RUN npm install

# Building app.
RUN npm run build --prod

### STAGE 2: Setup ###
FROM nginx:alpine

# Copying openhome-panel source into web server root.
COPY --from=node /app/dist/cmail/ /usr/share/nginx/html