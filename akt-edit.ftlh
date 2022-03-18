<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template akt>
    <hr>
        <form action="akt-edit/${akt.id}" method="post">
            <div class="form-group">
                <label for="aktTitle">Наименование</label>
                <input type="text" value="${akt.title}" required class="form-control"
                       id="productTitle" name="title">
            </div>
            <div class="form-group">
         <label for="aktDate">Дата поставки</label>
                                    <input type="date" value="${akt.date}" required class="form-control"
                                           id="aktDate" name="aktDate">
            </div>
            <div class="form-group">
                            <label for="aktBase">Наименование Базы</label>
                            <input type="text" value="${akt.base.title}" required class="form-control"
                                   id="aktBase" name="aktBase">
                        </div>
               <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </@t.template>
</@t.template>