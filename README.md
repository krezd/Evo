cd ../shop/product-service
docker build -t product-service:latest .

cd ../shop/order-service
docker build -t order-service:latest .

cd ../shop/user-service
docker build -t user-service:latest .

cd ../shop/discovery-server
docker build -t discovery-server:latest .

cd ../shop/docker
docker-compose up -d

cd ../shop/docker
docker-compose up --scale product-service=2 --scale order-service=2 --scale user-service=2 -d
