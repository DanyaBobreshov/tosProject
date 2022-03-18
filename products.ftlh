<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">ОВУ</h1><hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Наименование</th>
                    <th scope="col">Дата поставки</th>
                    <th scope="col">В наличии на базе</th>
                    <th scope="col">Акты</th>
                    <th scope="col">В наличии в частях</th>
                </tr>
                <#list products as product>
                <tr>
                    <th>${product.id}</th>
                    <th>${product.title}</th>
                    <th>${product.dateOfAddToBase}</th>
                    <th>${product.allInBase}</th>
                    <th><a href="/product-akts/${product.id}">Акты</a></th>
                    <th><a href="/product-invoicesIn/${product.id}">В наличии в частях</a></th>
                    <th><a href="/product/edit/${product.id}">Редактировние</a></th>
                    <th><a href="/product/delete/${product.id}">Удаление</a></th>
                </tr>
                <#else>
                <h3>Изделий нет</h3>
            </#list>
            </table>
    <form method="get" action="/products">
            <div class="form-group col-md-10">
                <label for="searchWord">Поиск по изделиям</label>
                <input type="text" name="searchWord" <#if searchWord??>value="${searchWord}"</#if> class="form-control"
                       id="searchWord">
            </div>
            <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
    </form>
    <hr>
 <hr>
    <a class="btn btn-dark mt-3 mb-3" style="text-align: center; width: 100%"
       data-toggle="collapse" href="#collapseExample" role="button"
       aria-expanded="true" aria-controls="collapseExample">
        Добавить новое изделие
    </a>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/product/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="productTitle">Наименование</label>
                <input type="text" required class="form-control"
                       id="productTitle" name="title">
            </div>
             <div class="form-group">
                            <label for="productDateOfAddToBase">Дата поставки</label>
                            <input type="date" required class="form-control"
                                   id="productDateOfAddToBase" name="dateOfAddToBase">
                        </div>
              <div class="form-group">
                              <label for="productAllInBase">В наличии на базе</label>
                              <div class="input-group mb-3">
                                  <input type="number" required class="form-control"
                                  id="productAllInBase" name="productAllInBase">
                              </div>
                          </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                        <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
                                </form>
        </form>
 </div>
   </@t.template>