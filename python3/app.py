import time
import urllib.request
import urllib.parse

now_seconds = time.time()
hashtag = "#foo"
url = "http://interview.gonumeral.com/search?q=" + urllib.parse.quote(hashtag)
url = url + "&beforeTimeSecondsInclusive=" + str(now_seconds + 3600)
url = url + "&afterTimeSecondsExclusive=" + str(now_seconds - 3600 * 2)
contents = urllib.request.urlopen(url).read()
print(contents)