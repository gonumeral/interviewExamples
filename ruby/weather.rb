require 'httparty'
require 'json'

open_weather_key = "MY_API_KEY"
geo_tag_url = "http://api.openweathermap.org/geo/1.0/direct?q=San Francisco&appid=#{open_weather_key}"
response = HTTParty.get(geo_tag_url)
data = JSON.parse(response.body)
lon = data[0]['lon']
lat = data[0]['lat']
weather_url = "https://api.openweathermap.org/data/2.5/weather?lat=#{lat}&lon=#{lon}&units=imperial&appid=#{open_weather_key}"
response = HTTParty.get(weather_url)
data = JSON.parse(response.body)
puts data["main"]["temp"]