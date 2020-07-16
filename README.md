##pull postgres
`docker pull postgres`

##run docker
`docker run -d --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres:latest`

##install redis
`sudo apt update`

`sudo apt install redis-server`

`sudo service redis-server start`