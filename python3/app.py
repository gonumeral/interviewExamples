import requests
import json


open_weather_key = "MY_API_KEY"
geo_tag_url = "http://api.openweathermap.org/geo/1.0/direct?q=%s&appid=%s" % ("San Francisco", open_weather_key )
response = requests.get(geo_tag_url)
data = json.loads(response.text)
lon = data[0]['lon']
lat = data[0]['lat']
weather_url="https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&units=%s&appid=%s" %(lat,lon,"imperial",open_weather_key)
response = requests.get(weather_url)
data = json.loads(response.text)
print(data["main"]["temp"])