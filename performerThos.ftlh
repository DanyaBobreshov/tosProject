<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Вторые исполнители</h1><hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Должность</th>
                    <th scope="col">Фамилия, инициалы</th>
                </tr>
                <#list performerthos as performertho>
                <tr>
                    <th>${performertho.id}</th>
                    <th>${performertho.rang}</th>
                    <th>${performertho.name}</th>
                    <th><a href="/performerTho/edit/${performertho.id}">Редактировние</a></th>
                    <th><a href="/performerTho/delete/${performertho.id}">Удаление</a></th>
                </tr>
                <#else>
                <h3>Исполнителей нет</h3>
            </#list>
            </table>
    <form method="get" action="/performerTho">
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
        Добавить нового исполнителя
    </a>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/performerTho/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="performerthoName">Фамилия, инициалы</label>
                <input type="text" required class="form-control"
                       id="performerthoName" name="name">
            </div>
            <div class="form-group">
                 <label for="performerthoRang">Должность</label>
                 <input type="text" required class="form-control"
                        id="performerthoRang" name="rang">
             </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                        <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
        </form>
 </div>
   </@t.template>