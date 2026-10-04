self.addEventListener('install', function(e) {
  e.waitUntil(
    caches.open('makhanani-v1').then(function(cache) {
      return cache.addAll(['./makhanani.html']);
    })
  );
});
self.addEventListener('fetch', function(e) {
  e.respondWith(
    caches.match(e.request).then(function(r) {
      return r || fetch(e.request);
    })
  );
});