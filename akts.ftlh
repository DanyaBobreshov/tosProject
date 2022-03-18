<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">ОВУ</h1><hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Наименование</th>
                    <th scope="col">База отгрузки</th>
                    <th scope="col">Дата приема</th>
                    <th scope="col">Добавленные изделия</th>
                    <th scope="col">Редактирование</th>
                    <th scope="col">Удаление</th>
                </tr>
                <#list akts as akt>
                <tr>
                    <th>${akt.id}</th>
                    <th>${akt.title}</th>
                    <th>${akt.base.title}</th>
                    <th>${akt.date}</th>
                    <th><a href="/akt/products/${akt.id}">Изделия</a></th>
                    <th><a href="/akt/edit/${akt.id}">Редактировние</a></th>
                    <th><a href="/akt/delete/${akt.id}">Удаление</a></th>
                </tr>
                <#else>
                <h3>Актов нет</h3>
            </#list>
            </table>

    <form method="get" action="/akts">
            <div class="form-group col-md-10">
                <label for="searchWord">Поиск по актам</label>
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
        Добавить новый акт
    </a>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/akt/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="aktTitle">Наименование</label>
                <input type="text" required class="form-control"
                       id="aktTitle" name="aktTitle">
            </div>
             <div class="form-group">
                            <label for="aktRegiment">База отгрузки</label>
                            <input type="text" value="41101" required class="form-control"
                                   id="aktRegiment" name="aktRegiment">
                        </div>
             <div class="form-group">
                            <label for="productDateOfAddToBase">Дата поставки</label>
                            <input type="date" required class="form-control"
                                   id="productDateOfAddToBase" name="aktDate">
                        </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                        <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
</form>
</div>
   </@t.template>