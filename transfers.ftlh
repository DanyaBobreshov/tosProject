<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Виды транспорта</h1><hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Наименование</th>
                </tr>
                <#list transfers as transfer>
                <tr>
                    <th>${transfer.id}</th>
                    <th>${transfer.title}</th>
                    <th><a href="/transfer/edit/${transfer.id}">Редактировние</a></th>
                    <th><a href="/transfer/delete/${transfer.id}">Удаление</a></th>
                </tr>
                <#else>
                <h3>Транспорта нет</h3>
            </#list>
            </table>
    <form method="get" action="/transfers">
            <div class="form-group col-md-10">
                <label for="searchWord">Поиск по транспорту</label>
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
        Добавить новый транспорт
    </a>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/transfer/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="transferTitle">Наименование</label>
                <input type="text" required class="form-control"
                       id="transferTitle" name="title">
            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                        <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
        </form>
 </div>
   </@t.template>