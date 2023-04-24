#!/bin/bash

# API endpoint
url="http://arch.homework/users"

# Number of requests to send
num_requests=50000

# Generate random data for each request
function generate_data() {
    username=$(head /dev/urandom | tr -dc a-z0-9 | head -c 8)
    first_name=$(head /dev/urandom | tr -dc A-Z | head -c 5)
    last_name=$(head /dev/urandom | tr -dc A-Z | head -c 5)
    email="${username}@example.com"
    phone="+7$(shuf -i 10000000000-99999999999 -n 1)"
    created_at=$(date +%s)
    data="{\"username\": \"$username\", \"firstName\": \"$first_name\", \"lastName\": \"$last_name\", \"email\": \"$email\", \"phone\": \"$phone\", \"createdAt\": $created_at}"
    echo $data
}

# Send requests and measure response time
total_time=0
for (( i=1; i<=$num_requests; i++ )); do
    data=$(generate_data)
    start_time=$(date +%s.%N)
    response=$(curl -s -X POST -H "Content-Type: application/json" -d "$data" $url)
    end_time=$(date +%s.%N)
    response_time=$(echo "$end_time - $start_time" | bc)
    total_time=$(echo "$total_time + $response_time" | bc)
    status_code=$(echo "$response" | jq -r ".statusCode")
    echo "Request $i: $status_code, response time: $response_time seconds"
done

# Print benchmark results
avg_response_time=$(echo "scale=4; $total_time / $num_requests" | bc)
echo -e "\nBenchmark results:"
echo "Number of requests sent: $num_requests"
echo "Total time taken: $total_time seconds"
echo "Average response time: $avg_response_time seconds"
