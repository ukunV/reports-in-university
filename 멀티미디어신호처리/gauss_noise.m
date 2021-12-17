%signal with gaussian noise

n = 0:100;
x = cos(0.04*pi*n);
w = 0.2*randn(size(n)); % size(n) = 101

y = x+w;

figure(1)
subplot(311)
stem(n, x); title('x[n]');
subplot(312)
stem(n, w); title('gaussian noise');
subplot(313);
stem(n, y); title('noisy signal');