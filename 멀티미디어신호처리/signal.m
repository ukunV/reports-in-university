% sinusoidal signal
n = 0:10;
x = 3*cos(0.1*pi*n+pi/3) + 2*sin(0.5*pi*n);

% complex exponential
n = 0:10;
y = exp((2+3*j)*n);

figure('Name','signal','NumberTitle','off');
subplot(211) % (행/열/위치)
stem(n, x)
subplot(212)
stem(n, abs(y))