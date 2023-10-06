# STAGE 1 : build the app
FROM node:latest as node
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build


# STAGE 2 : run the app
FROM nginx:latest
COPY --from=node /app/dist/product-frontend /usr/share/nginx/html
EXPOSE 80