import boto3
rds = boto3.client('rds')

try:
    dbs = rds.describe_db_instances()
    for db in dbs['DBInstance']:
        print("%s@%s:%s %s") % (db['MasterUsername'], db['Endpoint']['Address'], db['Endpoint']['Port'], db['DBInstanceState'])

except Exception as e:
    print(e)
