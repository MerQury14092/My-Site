<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <title>Nsds</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/album/">
    <meta name="theme-color" content="#712cf9">
</head>

<body>
<div class="navbar navbar-dark bg-dark shadow-sm">
    <div class="container">
        <a href="/" class="navbar-brand d-flex align-items-center">
            <strong>Za Avito</strong>
        </a>
        <a href="/prod/create/page" class="navbar-brand d-flex align-items-center">
            <strong>Создать объявление</strong>
        </a>
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
                                <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="true"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">No Image</text></svg>
                                <div class="card-body">
                                    <p class="card-text"><b>${prod[0].title}</b></p><br>
                                    <p class="card-text">${prod[0].description}</p>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-sm btn-outline-secondary" onclick="window.location.href='/prod/${prod[0].id}'">Подробнее</button>
                                        </div>
                                        <small class="text-body-secondary">${prod[0].price} &#8381;</small>
                                        <small class="text-body-secondary">${prod[0].dateOfCreated.toLocalDate()}  ${prod[0].dateOfCreated.toLocalTime()}</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </#if>
                    <#if prod[1]??>
                    <div class="col">
                        <div class="card shadow-sm">
                            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">No Image</text></svg>
                            <div class="card-body">
                                <p class="card-text"><b>${prod[1].title}</b></p><br>
                                <p class="card-text">${prod[1].description}</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-outline-secondary" onclick="window.location.href='/prod/${prod[1].id}'">Подробнее</button>
                                    </div>
                                    <small class="text-body-secondary">${prod[1].price} &#8381;</small>
                                    <small class="text-body-secondary">${prod[1].dateOfCreated.toLocalDate()}  ${prod[1].dateOfCreated.toLocalTime()}</small>
                                </div>
                            </div>
                        </div>
                    </div>
                    </#if>
                    <#if prod[2]??>
                    <div class="col">
                        <div class="card shadow-sm">
                            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">No Image</text></svg>
                            <div class="card-body">
                                <p class="card-text"><b>${prod[2].title}</b></p><br>
                                <p class="card-text">${prod[2].description}</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-outline-secondary" onclick="window.location.href='/prod/${prod[2].id}'">Подробнее</button>
                                    </div>
                                    <small class="text-body-secondary">${prod[2].price} &#8381;</small>
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
</main>
</body>
</html>