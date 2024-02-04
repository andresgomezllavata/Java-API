# SUPERHERO API DOCUMENTATION

This is an API REST aimed to maintain a superhero Data Base with CRUD methods.


## ENDPOINTS

* ## `/init`
    ### `GET`

    This method initializes the Database with six different values.

    ### RESPONSE SAMPLE
    ```
    La base de datos ha sido inicializada correctamente.
    ``` 


* ## `/findAll`
    ### `GET`
    This method will retrieve a list of all superheroes found in the Data Base.

    ### RESPONSE SAMPLE
    ```
    [
        {
            "name": "Batman",
            "city": "Ciudad Gotica",
            "power": "Ninguno"
        },
        {
            "name": "Superman",
            "city": "Metropolis",
            "power": "Volar"
        },
        {
            "name": "Spiderman",
            "city": "Nueva York",
            "power": "Telarañas"
        }
    ]
    ```     

* ## `/findByName/{name}`
    ### `GET`
    This method will retrieve -if exists- the superhero with name recieved in the `name` param.
    
    ### RESPONSE SAMPLE
    ```
    {
        "name": "Superman",
        "city": "Metropolis",
        "power": "Volar"
    }
    ```


* ## `/findByNameContaining/{partialName}`
    ### `GET`
    This endpoint will retrieve a list of all superheroes existing in the database with their names containing the `partialName` param. For example, this endpoint called with `partialName="man"` will retrieve superheroes like Batman, Superman, Spiderman, etc.

    ### RESPONSE SAMPLE
    ```
    [
        {
            "name": "Batman",
            "city": "Ciudad Gotica",
            "power": "Ninguno"
        },
        {
            "name": "Superman",
            "city": "Metropolis",
            "power": "Volar"
        },
        {
            "name": "Spiderman",
            "city": "Nueva York",
            "power": "Telarañas"
        },
        {
            "name": "Ironman",
            "city": "Nueva York",
            "power": "Ninguno"
        }
    ]
    ```

* ## `/create`
    ### `POST`
    This endpoint will create -if possible- a new superhero in the Data Base.

    ### REQUEST BODY SAMPLE
    ```
    {
        "name": "Aquaman",
        "city": "Atlantis",
        "power": "Hablar con los peces",
        "wearsCape": false
    }
    ```

    The API will first check if Aquaman already existed on the Data Base, therefore the response will depend on it.
    ### RESPONSE SAMPLE
    ```
    Aquaman ha sido dado de alta correctamente.
    ```
    or
    ```
    Aquaman ya se encontraba dado de alta en nuestra base de datos.
    ```

* ## `/update`
    ### `PUT`
    This endpoint will first check ir the superhero on the request body exist on the Data Base. If true, then it will be updated, if not, it will notify that the superhero couldn't be found.
    ### REQUEST BODY SAMPLE
    ```
    {
        "name": "Batman",
        "city": "Metropolis",
        "power": "Ninguno",
        "wearsCape": true
    }
    ```

* ## `/delete/{name}`
    ### `DELETE`
    This method will delete superhero with name recieved in the `name` param. Response will depend whether the superhero existed or not in the Data Base.

    ### RESPONSE SAMPLE
    ```
    Superman ha sido eliminado correctamente de nuestra base de datos.
    ```
    or
    ```
    Superman no se encuentra dado de alta en nuestra base de datos.
    ```


* ## `/deleteAll`
    ### `DELETE`
    This endpoint recieves no params. All superheroes on the Data Base will be deleted.

