<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template performertho>
    <hr>
        <form action="performerTho-edit/${performertho.id}" method="post">
    <div class="form-group">
                    <label for="performerthoName">Фамилия, инициалы</label>
                    <input type="text" value="${performertho.name}" required class="form-control"
                           id="performerthoName" name="name">
                </div>
                <div class="form-group">
                     <label for="performerthoRang">Должность</label>
                    <input type="text" value="${performertho.rang}" required class="form-control"
                            id="performerthoRang" name="rang">
                 </div>
               <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </@t.template>
</@t.template>