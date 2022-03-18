<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Финансовые организации</h1><hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Наименование</th>
                </tr>
                <#list finorgans as finorgan>
                <tr>
                    <th>${finorgan.id}</th>
                    <th>${finorgan.title}</th>
                    <th><a href="/finorgan/edit/${finorgan.id}">Редактировние</a></th>
                    <th><a href="/finorgan/delete/${finorgan.id}">Удаление</a></th>
                </tr>
                <#else>
                <h3>Организаций нет</h3>
            </#list>
            </table>
    <form method="get" action="/finorgans">
            <div class="form-group col-md-10">
                <label for="searchWord">Поиск по организациям</label>
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
        Добавить новую Финансовую организацию
    </a>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/finorgan/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="finorganTitle">Наименование</label>
                <input type="text" required class="form-control"
                       id="finorganTitle" name="title">
            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                        <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
        </form>
 </div>
   </@t.template>