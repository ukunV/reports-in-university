% Sampling frequency Fs = 8000Hz
% Generate two sinusoid frequency 1000Hz, and 2000Hz

% digital conversion with sampling frequency
fs = 8000;
t = 0:1/fs:1; % 8001
x1 = 2*cos(2*pi*1000*t);
x2 = 4*cos(2*pi*2000*t);

% Frequency spectrum
y1 = abs(fft(x1, fs));
y2 = abs(fft(x2, fs));

% time-domain plot
figure(1)
subplot(221);
plot(t(1:50), x1(1:50));
xlabel('time[mse]'); ylabel('amplitude');
title('x1(t) = 2cos(2pi(1000)t');
subplot(222);
plot(t(1:50), x2(1:50));
xlabel('time[mse]'); ylabel('amplitude');
title('x2(t) = 4cos(2pi(2000)t');

% frequency spectrum plot
fi = 1:1:fs;
subplot(223);
plot(fi, y1(1:fs));
xlabel('frequency[Hz]'); ylabel('magnitude');
title('frequency spectrum for x1');
subplot(224);
plot(fi, y2(1:fs));
xlabel('frequency[Hz]'); ylabel('magnitude');
title('frequency spectrum for x2');