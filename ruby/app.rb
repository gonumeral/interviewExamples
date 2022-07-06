require 'date'
require 'uri'
require 'net/http'

now = Time.now.to_f

hashtag = '#foo'
uri = 'http://interview.gonumeral.com/search?q=' + URI.escape(hashtag)
uri = uri + '&beforeTimeSecondsInclusive=' + (now + 3600).to_s
uri = uri + '&afterTimeSecondsExclusive=' + (now - 7200).to_s

res = Net::HTTP.get_response(URI(uri))
puts res.body if res.is_a?(Net::HTTPSuccess)