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
