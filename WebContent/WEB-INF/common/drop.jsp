<div class="input-group">
	<div class="rs-select2 js-select-simple select--no-search">
		<div class="select-dropdown"></div>
		<form:select path="playerLevel">

			<c:forEach items="${model.player}" var="r">

				<form:option value="${r.playerLevel}"></form:option>
			</c:forEach>
		</form:select>
	</div>
</div>
