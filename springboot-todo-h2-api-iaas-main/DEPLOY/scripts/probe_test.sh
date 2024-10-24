#!/bin/bash

function get_todos_by_user(){
    echo ""
}


function delete_todo(){
    echo ""
}


function get_todos_by_status(){
    echo ""
}


function update_todo(){
    endpoint=$1
    echo ""
}

function post_todo(){
    endpoint=$1
    echo ""
}

function get_all_todos(){
    endpoint=$1
    echo ""
}

function login_user(){
    endpoint=$1
    echo "login"
}

function post_user(){
    endpoint=$1

    echo "post user"
}

function get_all_users(){
    endpoint=$1

    echo "Get all users"
}


function verify_api_availability(){
    endpoint=$1
    status_response=1
    api_endpoint="${endpoint}/v4/api-docs"    

    echo "Verify is API is abailable on ${api_endpoint}"
    http_code=$(curl --write-out "%{http_code}\n" --output /dev/null --silent  $api_endpoint ) 
    echo "The status code was ${http_code}"
    
    case ${http_code} in
        200)
            echo "The API is availble"
            status_response=0
            ;;
        404)    
            echo "The API is not found, verify host and enpoint"
            ;;
        000)
            echo "shell can not connect with the API"
            ;;    
        *)   
            echo "Verify the app, settings and environment" 
    esac

    return status_response
}


function execute_test(){
    host=$1
    environment=$2
    is_production=$3

    endpoint="$host/api/todoapp"

    echo "######################################"    
    echo "executing test on endpont $host , environment ${environment}, is Production ${is_production}"

    verify_api_availability $endpoint 
    is_api_available=$?

    if [ $is_api_available == 0 ]; then
        echo ""
        echo "Starg testing"
    else
        echo "Endpoint not available, suspending test on environment ${environment}"
    fi

}


function start_test(){
    echo "Execute API test"

    while read current_row; do
        IFS=','
        read -a current_values <<< "$current_row"

        echo "Current row values are:  ${current_values}"
        echo ""

        current_host=${current_values[0]}
        current_environment=${current_values[1]}
        is_production=${current_values[2]}

        execute_test $current_host $current_environment $is_production
        
    done < environments.csv

    echo "End of testing"
}


start_test