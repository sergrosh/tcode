<div class="controls" id="link${index}">
    <input name="${Constants.LINK_TITLE}${index}" type="text" placeholder="Link title" value="${link.title}"/>

    <div class="input-append input-xxlarge">
        <input class="input-block-level" name="${Constants.LINK_URL}${index}" type="text" placeholder="Url"
               data-required="true"
               data-type="url"
               data-error-container="#linkErrors"
               value="${link.url}"
               data-trigger="focusout"/>
        <button onClick="removeLink(${index})" class="btn btn-info" type="button">-</button>
    </div>
</div>