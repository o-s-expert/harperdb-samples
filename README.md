# harperdb-samples

The integration of HarpderDB and Java samples


docker run -d \
  -e HDB_ADMIN_USERNAME=root \
  -e HDB_ADMIN_PASSWORD=password \
  -e HTTP_THREADS=4 \
  -p 9925:9925 \
  -p 9926:9926 \
  harperdb/harperdb


 curl --location --request POST 'http://localhost:9925/' \
--header 'Authorization: Basic cm9vdDpwYXNzd29yZA==' \
--header 'Content-Type: application/json' \
--data-raw '{
"operation": "create_schema",
"schema": "dev"
}'




curl --location 'http://localhost:9925' \
--header 'Authorization: Basic cm9vdDpwYXNzd29yZA==' \
--header 'Content-Type: application/json' \
--data '{
    "operation": "create_table",
    "schema": "dev",
    "table": "person",
    "hash_attribute": "id"
}'

curl --location 'http://localhost:9925' \
--header 'Authorization: Basic cm9vdDpwYXNzd29yZA==' \
--header 'Content-Type: application/json' \
--data '{
    "operation": "create_attribute",
    "schema": "dev",
    "table": "person",
    "attribute": "name"
}'

curl --location 'http://localhost:9925' \
--header 'Authorization: Basic cm9vdDpwYXNzd29yZA==' \
--header 'Content-Type: application/json' \
--data '{
    "operation": "create_attribute",
    "schema": "dev",
    "table": "person",
    "attribute": "age"
}'