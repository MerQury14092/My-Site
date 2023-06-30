<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <title>Z</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/album/">
    <meta name="theme-color" content="#712cf9">
    <style>
        body{
            background-color: #2b3035;
        }
        .col {
            animation: 2s show ease;
        }

        @keyframes show {
            from { opacity: 0; }
            to { opacity: 1; }
        }
        #window {
            width: 300px;
            height: 300px;
            text-align: center;
            padding: 15px;
            border: 3px solid #212529;
            border-radius: 10px;
            color: #212529;
            /*позиционируем и центрируем*/
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto;
            background-color: #2b3035;
            overflow: hidden;
        }
        #hide {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgb(0,0,0,0.5);
        }
        #create {
            display: none;
        }
        #create:target {
            display: block;
        }
        .text-field {
            margin-top: 10px;
            border-width: 0;
            border-radius: 20px;
        }

    </style>
</head>

<body>
<div class="navbar navbar-dark bg-dark shadow-sm">
    <div class="container">
        <a href="/" class="navbar-brand d-flex align-items-center">
            <strong>Za Avito</strong>
        </a>
        <a href="#create" class="navbar-brand d-flex align-items-center">
            <strong>Создать объявление</strong>
        </a>
        <a href="/api" class="navbar-brand d-flex align-items-center">API</a>
    </div>
</div>
<main>
    <#list products?chunk(3) as prod>
        <div class="album py-5 bg-body-tertiary">
            <div class="container">
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                    <#if prod[0]??>
                        <div class="col">
                            <div class="card shadow-sm">
                                <img class="image" src="${prod[0].urlToImage}" height="250">
                                <div class="card-body">
                                    <p class="card-text"><b>${prod[0].title}</b></p><br>
                                    <p class="card-text">${prod[0].description}</p>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-sm btn-outline-secondary" onclick="window.location.href='/prod/${prod[0].id}'">Подробнее</button>
                                        </div>
                                        <small class="text-body-secondary price">${prod[0].price}</small>
                                        <small class="text-body-secondary">${prod[0].dateOfCreated.toLocalDate()}  ${prod[0].dateOfCreated.toLocalTime()}</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </#if>
                    <#if prod[1]??>
                    <div class="col">
                        <div class="card shadow-sm">
                            <img class="image" src="${prod[1].urlToImage}" height="250">
                            <div class="card-body">
                                <p class="card-text"><b>${prod[1].title}</b></p><br>
                                <p class="card-text">${prod[1].description}</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-outline-secondary" onclick="window.location.href='/prod/${prod[1].id}'">Подробнее</button>
                                    </div>
                                    <small class="text-body-secondary price">${prod[1].price}</small>
                                    <small class="text-body-secondary">${prod[1].dateOfCreated.toLocalDate()}  ${prod[1].dateOfCreated.toLocalTime()}</small>
                                </div>
                            </div>
                        </div>
                    </div>
                    </#if>
                    <#if prod[2]??>
                    <div class="col">
                        <div class="card shadow-sm">
                            <img class="image" src="${prod[2].urlToImage}" height="250">
                            <div class="card-body">
                                <p class="card-text"><b>${prod[2].title}</b></p><br>
                                <p class="card-text">${prod[2].description}</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-outline-secondary" onclick="window.location.href='/prod/${prod[2].id}'">Подробнее</button>
                                    </div>
                                    <small class="text-body-secondary price">${prod[2].price}</small>
                                    <small class="text-body-secondary">${prod[2].dateOfCreated.toLocalDate()}  ${prod[2].dateOfCreated.toLocalTime()}</small>
                                </div>
                            </div>
                        </div>
                    </div>
                    </#if>
                </div>
            </div>
        </div>
    </#list>

    <div id="create">
        <a href="#" id="hide"></a>
        <div id="window">
            <form action="/prod/create" method="post">
                <input type="text" name="title" placeholder="Название" class="text-field">
                <br>
                <input type="text" name="description" placeholder="Описание" class="text-field">
                <br>
                <input type="number" name="price" placeholder="Цена &#8381;" class="text-field">
                <br>
                <input type="text" name="city" placeholder="Город" class="text-field">
                <br>
                <input type="text" name="author" placeholder="Автор" class="text-field">
                <br>
                <input type="text" name="urlToImage" placeholder="URL фото" class="text-field">
                <br>
                <input type="submit" value="Добавить товар" class="text-field">
            </form>
        </div>
    </div>
</main>
</body>
<script>
    const elements = document.getElementsByClassName("price")
    for (let i = 0; i < elements.length; i++){
        let text = elements[i].innerHTML
        if(text === "0"){
            elements[i].innerHTML = "Бесплатно"
        }
        else {
            elements[i].innerHTML = elements[i].innerHTML + " &#8381;"
        }
    }

    const images = document.getElementsByClassName("image")
    for(let i = 0; i < images.length; i++){
        images[i].onerror = function () {
            images[i].src = "https://t4.ftcdn.net/jpg/04/99/93/31/360_F_499933117_ZAUBfv3P1HEOsZDrnkbNCt4jc3AodArl.jpg"
        }
    }
</script>
</html>