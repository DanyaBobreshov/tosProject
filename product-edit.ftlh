<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template product>
    <hr>
        <form action="product-edit/${product.id}" method="post">
            <div class="form-group">
                <label for="productTitle">Наименование</label>
                <input type="text" value="${product.title}" required class="form-control"
                       id="productTitle" name="title">
            </div>
            <div class="form-group">
         <label for="productDateOfAddToBase">Дата поставки</label>
                                    <input type="date" value="${product.dateOfAddToBase}" required class="form-control"
                                           id="productDateOfAddToBase" name="dateOfAddToBase">
            </div>
            <div class="form-group">
            <label for="productAllInBase">В наличии на базе</label>
                                          <div class="input-group mb-3">
                                              <input type="number" value="${product.allInBase}" required class="form-control"
                                              id="productAllInBase" name="allInBase">
                                          </div>
                                      </div>
               <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </@t.template>
</@t.template>