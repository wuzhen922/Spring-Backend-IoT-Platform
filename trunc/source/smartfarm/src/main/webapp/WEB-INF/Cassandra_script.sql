Create keyspace 'smartfarm':
create keyspace if not exists smartfarm with replication = {'class':'SimpleStrategy', 'replication_factor':3};