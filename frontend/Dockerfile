# Frontend Dockerfile - serve static site with nginx
FROM nginx:stable-alpine
COPY . /usr/share/nginx/html:ro
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]