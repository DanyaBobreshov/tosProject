<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">ОВУ</h1><hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Наименование</th>
                    <th scope="col">Полное наименование и адрес</th>
                    <th scope="col">Финансовая организация</th>
                    <th scope="col">ОВУ</th>
                </tr>
                <#list regiments as regiment>
                <tr>
                    <th>${regiment.id}</th>
                    <th>${regiment.title}</th>
                    <th>${regiment.name}</th>
                    <th>${regiment.finOrgan.title}</th>
                    <th>${regiment.division.title}</th>
                    <th><a href="/regiment/edit/${regiment.id}">Редактировние</a></th>
                    <th><a href="/regiment/delete/${regiment.id}">Удаление</a></th>
                </tr>
                <#else>
                <h3>Организаций нет</h3>
            </#list>
            </table>
    <form method="get" action="/regiments">
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
        Добавить новую Войсковую часть
    </a>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/regiment/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="regimentTitle">Наименование</label>
                <input type="text" required class="form-control"
                       id="regimentTitle" name="title">
            </div>
             <div class="form-group">
                            <label for="regimentName">Полное наименование и адрес</label>
                            <input type="text" required class="form-control"
                                   id="divisionName" name="name">
                        </div>
              <div class="form-group">
                             <label for="regimentFinOrgan">Финансовая организация</label>
                             <input type="text" required class="form-control"
                                    id="regimentFinOrgan" name="finOrgan">
                         </div>
              <div class="form-group">
                             <label for="regimentDivision">ОВУ</label>
                             <input type="text" required class="form-control"
                                    id="regimentDivision" name="division">
                         </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                        <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
        </form>
 </div>
   </@t.template>