const fetch = require('node-fetch');

(async () => {
  const hashTag = '#foo';
  const oneHourLater = new Date((new Date()).getTime() + 3600 * 1000);
  const twoHoursEarlier = new Date((new Date()).getTime() - 3600 * 1000 * 2);

  const resp = await fetch(`http://interview.gonumeral.com/search?q=${encodeURIComponent(hashTag)}&beforeTimeSecondsInclusive=${oneHourLater.getTime() / 1000}&afterTimeSecondsExclusive=${twoHoursEarlier.getTime() / 1000}`);
  const text = await resp.text();
  console.log(text);
})();