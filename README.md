<h2>Регистрация</h2>

Что бы зарегистрироваться, отправьте http запрос методом POST, в теле которого будет JSON-объект по 
[этой модели](https://github.com/MerQury14092/My-Site#модель-данных-пользователя)

URL: **http://merqury.fun/api/auth/registration**
<hr>

<h2>Получение токена</h2>
<p>Что бы получить API токен, отправьте http запрос методом GET с такими параметрами:</p>

* ***username*** - имя пользователя
* ***password*** - пароль

В результате вам вернётся ответ в JSON и если пользователь будет найден, токен будет записан в свойстве `response_text`

URL: **http://merqury.fun/api/auth/token**
<hr>
<h2>Получение списка продуктов</h2>
<p>Для получения списка товаров, выполните http запрос методом GET</p>

URL: ***http://merqury.fun/api/prod***
<br><br>
Если хотите получить отдельный товар по ID, то тогда к URL добавьте `/{id}`
<br>

Так же вы можете получить список продуктов определённого пользователя, добавив в конец URL `/by/{username}`
<hr>

<h1>ВНИМАНИЕ!!!</h1>
<p>Все нижеописанные запросы должны быть авторизованны</p>
<p>Для авторизации добавьте URL параметр:</p>

* `token=<your token>`
<hr>

<hr>
<h1>Действия с пользователями</h1>
<hr>


<h2>Изменение пользователя</h2>
Для изменения пользователя, вы должны отправить http запрос методом PUT, в теле которого будет JSON объект с изменяемыми свойствами

([модель пользователя](https://github.com/MerQury14092/My-Site#%D0%BC%D0%BE%D0%B4%D0%B5%D0%BB%D1%8C-%D0%B4%D0%B0%D0%BD%D0%BD%D1%8B%D1%85-%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8F))

URL: ***http://merqury.fun/api/auth/user***
<hr>

<h2>Удаление пользователя</h2>
<p>Для изменения пользователя, вы должны отправить http запрос методом DELETE</p>

URL: ***http://merqury.fun/api/auth/user***
<hr>

<h2>Узнать имя пользователя по токену</h2>

При удачном выполнении запроса, имя пользователя ищите в свойстве `response_text`

URL: ***http://merqury.fun/api/auth/whois***
<hr>

<hr>
<h1>Действия с продуктами</h1>
<hr>

<h2>Добавление продукта</h2>

Для добавления продукта выполните http запрос методом POST, в теле которого будет JSON-объект описывающий [модель продукта](https://github.com/MerQury14092/My-Site#%D0%BC%D0%BE%D0%B4%D0%B5%D0%BB%D1%8C-%D0%BF%D1%80%D0%BE%D0%B4%D1%83%D0%BA%D1%82%D0%B0), исключая эти свойства:

* ***id*** - это свойство присваивается автоматически сервером
* ***author*** - в этом поле будет ***username*** пользователя, добавляющего продукт
* ***dateOfCreated*** - это свойство присваивается автоматически сервером

<p>Так же опциональны эти свойства:</p>

* ***description*** - автоматически добавится описание "No description"
* ***urlToImage***

URL: ***http://merqury.fun/api/prod***
<hr>

<h2>Изменение продукта по ID</h2>
Для изменения продукта по ID, выполните http запрос методом PUT, в теле которого будет JSON-объект с изменяемыми свойствами продукта

([модель продукта](https://github.com/MerQury14092/My-Site#%D0%BC%D0%BE%D0%B4%D0%B5%D0%BB%D1%8C-%D0%BF%D1%80%D0%BE%D0%B4%D1%83%D0%BA%D1%82%D0%B0))

URL: ***http://merqury.fun/api/prod/{id}***
<hr>

<h2>Удаление продукта по ID</h2>
<p>Для удаления продукта по ID, выполните http запрос методом DELETE</p>

URL: ***http://merqury.fun/api/prod/{id}***

<hr>
<hr>
<h3>Модель продукта:</h3>

```
{
    "id": 1, // идентификатор продукта
    "title": "имя продукта",
    "description": "описание продукта",
    "price": 100, // цена продукта
    "author": "автор",
    "city": "город",
    "dateOfCreated": "дата создания продукта",
    "urlToImage": "путь до изображения товара"
}
```
<br>
<p>Так же при запросах в большинстве случаев вы получите ответ в формате JSON</p>
<h3>Модель ответа:</h3>

```
{
    "response_code": 200, // код ответа (в основном используются коды HTTP)
    "response_text": "описание ответа"
}
```
<p>При регистрации, вы должны отправить данные о пользователе в JSON формате, модель для этого написана ниже</p>
<h3>Модель данных пользователя:</h3>

```
{
    "username": "Имя пользователя (должно быть уникально)",
    "password": "Пароль"
}
```