import json
from elasticsearch import Elasticsearch

client = Elasticsearch([{"host": "127.0.0.1", "port": 9200, "scheme": "http"}])
indexName = "medical"
client.indices.delete(index=indexName)
client.indices.create(index=indexName)

appMapping = {
    "settings": {
        "analysis": {
            "filter": {
                "russian_stop": {
                    "type": "stop",
                    "stopwords": "_russian_"
                }
                # "russian_stemmer": {
                # "type":       "stemmer",
                # "language":   "russian"
                # },
                # "ru_snow": {
                # "type": "snowball",
                # "language": "Russian"
                # }
            },
            # "analyzer": {
            #     "rebuilt_russian": {
            #     "tokenizer":  "standard",
            #     "filter": [
            #         "lowercase",
            #         "russian_stop",
            #         "russian_stemmer",
            #         "ru_snow"
            #     ]
            #     }
            # }
        }
    },
    "properties": {
        "id_patient": {
            "type": "integer",
        },
        "age": {
            "type": "integer",
        },
        "personal_data": {
            "type": "text",
        },
        "id_appointment": {
            "type": "integer",
        },
        "date_appointment": {
            "type": "date",
        },
        "id_doctor": {
            "type": "integer",
        },
        "data_examination": {
            "type": "text",
        },
        "diagnosis": {
            "type": "text",
        },
        "refferals": {
            "type": "text",
        },
        "receips": {
            "type": "text",
        },
    }
}

client.indices.put_mapping(index=indexName,
                           doc_type="appointment",
                           include_type_name=True,
                           body=appMapping)

with open('apps.json', 'r') as f:
    dataStore = json.load(f)
for data in dataStore:
    try:
        client.index(index=data["index"],
                     doc_type=data["doc_type"],
                     id=data["id"],
                     body=data["body"])
    except Exception as e:
        print(e)
