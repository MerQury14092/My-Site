<h1>Регистрация</h1>
<p>Что бы зарегистрироваться, отправьте http запрос методом POST, в теле которого будет JSON-объект, содержащий три свойства:</p>

* ***username*** - имя пользователя
* ***email*** - адрес электронной почты
* ***password*** - пароль

на URL: **http://merqury.fun/api/auth/registration**
<hr>

<h1>Получение токена</h1>
<p>Что бы получить API токен, отправьте http запрос методом GET с такими параметрами:</p>

* ***email*** - адрес электронной почты
* ***password*** - пароль

на URL: **http://merqury.fun/api/auth/token**
<hr>
  <h1>Get list products</h1>
    <p>For getting list of products, you should complete GET request on http://merqury.fun/api/prod/</p>
    <hr>
    <h1>Get product by id</h1>
    <p>For getting product by id, you should complete GET request on http://merqury.fun/api/prod/{id}</p>
    <hr>
    <h1>Add product</h1>
    <p>For adding product, you should complete POST request with json object in body on http://merqury.fun/api/prod/</p>
    <hr>
    <h1>Remove product by id</h1>
    <p>For removing product by id, you should complete DELETE request on http://merqury.fun/api/prod/{id}</p>
    <hr>
    <h1>Change product by id</h1>
    <p>For changing product by id, you should complete PUT request with json object(Product, which contains only changing properties) in body on http://merqury.fun/api/prod/{id}</p>
