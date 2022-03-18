<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template performerone>
    <hr>
        <form action="performerOne-edit/${performerone.id}" method="post">
    <div class="form-group">
                    <label for="performeroneName">Фамилия, инициалы</label>
                    <input type="text" value="${performerone.name}" required class="form-control"
                           id="performeroneName" name="name">
                </div>
                <div class="form-group">
                     <label for="performeroneRang">Должность</label>
                    <input type="text" value="${performerone.rang}" required class="form-control"
                            id="performeroneRang" name="rang">
                 </div>
               <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </@t.template>
</@t.template>