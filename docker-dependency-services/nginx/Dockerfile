FROM nginx:alpine
COPY nginx.conf /etc/nginx/conf.d
RUN apk add busybox-extras
RUN apk add nano
CMD ["nginx", "-g", "daemon off;"]