# SAProject
Git Repo for SA Project

# Pull the project 
git clone https://github.com/mrBEASTBOY/SAProject.git

# Set up ELK Stack
Download Elasticsearch 7.15.1 
https://www.elastic.co/downloads/past-releases/elasticsearch-7-15-1
Download Kibana 7.15.1
https://www.elastic.co/downloads/past-releases/kibana-7-15-1
Download Logstash 7.15.1
https://www.elastic.co/downloads/past-releases/logstash-7-15-1

# Configuration file:
1. elasticsearch.yml:
Add this line to the last of the file
xpack.security.enabled: true

2. kibana.yml:
Uncomment username and password of the elasticsearch
elasticsearch.username: "kibana_system"
elasticsearch.password: "linhle1997"

3. logstash.conf
input {
	file {
		type => "product"
		path => "D:/springcloudtraining/temp/product-elk.log"
		start_position => "beginning"
	}
	file {
		type => "stock"
		path => "D:/springcloudtraining/temp/stock-elk.log"
		start_position => "beginning"
	}
	file {
		type => "API-Gateway"
		path => "D:/springcloudtraining/temp/apiGateway.log"
		start_position => "beginning"
	}
	file {
		type => "configServer"
		path => "D:/springcloudtraining/temp/configServer.log"
		start_position => "beginning"
	}
	file {
		type => "eureka"
		path => "D:/springcloudtraining/temp/eureka.log"
		start_position => "beginning"
	}
	file {
		type => "client"
		path => "D:/springcloudtraining/temp/client.log"
		start_position => "beginning"
	}
}

output {
    stdout {
        codec => rubydebug
    }
    elasticsearch {
        hosts => ["http://localhost:9200"]
	index => "logstash-%{+YYYY.MM.dd}"
        user => "elastic"
        password => "linhle1997"
    }
}

# Set up minimal security for elastic, kibana
1. On every node in your cluster, add the xpack.security.enabled setting to the $ES_PATH_CONF/elasticsearch.yml file and set the value to true:
xpack.security.enabled: true

2. On every node in your cluster, start Elasticsearch. For example, if you installed Elasticsearch with a .tar.gz package, run the following command from the ES_HOME directory:
./bin/elasticsearch

3. In another terminal window, set the passwords for the built-in users by running the elasticsearch-setup-passwords utility.
run the command with the interactive parameter instead of the auto parameter. Using this mode steps you through password configuration for all of the built-in users. Set the password for everything as "linh1997"
./bin/elasticsearch-setup-passwords interactive

4. Save the generated passwords. You’ll need them to add the built-in user to Kibana.

5. Add the elasticsearch.username setting to the KIB_PATH_CONF/kibana.yml file and set the value to the kibana_system user:
elasticsearch.username: "kibana_system"

6. From the directory where you installed Kibana, run the following commands to create the Kibana keystore and add the secure settings:
a. Create the Kibana keystore:
./bin/kibana-keystore create
b. Add the password for the kibana_system user to the Kibana keystore. Enter the password as "linh1997":
./bin/kibana-keystore add elasticsearch.password

7. Start kibana, username is "elastic", password is "linh1997"
./bin/kibana

8. Start logstash.bat
 
