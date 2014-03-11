class HashMap

	constructor: (@size, @entry) ->
		@size = 0
		@entry = new Object()

	put: (key, value) ->
		if not @containsKey(key) 
			@size = @size+1
		@entry[key] = value

	get: (key) ->
		if @containsKey(key) then @entry[key] else null

	remove: (key) ->
		if @containsKey(key) and (delete @entry[key])
			@size = @size - 1

	containsKey: (key) ->
		return key of @entry

	containsValue: (value) ->
		for k,v of @entry
			if @entry[k] is value
				return true 
		return false 

	values: ->
		values = new Array() 
		for prop of @entry 
			values.push(@entry[prop])
		return values

	keys: ->
		keys = new Array()
		for prop of @entry
			keys.push(prop)
		return keys

	clear: ->
		@size = 0 
		@entry = new Object()


