x = [3, 11, 7, 0, -1, 4, 2];
h = [2, 3, 0, -5, 2, 1];

tic
y = conv(h, x); % convolution
toc

z = [zeros(1, 2), y, zeros(1, 2)]; % zeros(1, 2): 1차원 zeros 2개
n = -5:1:10; % -2부터 7까지 간격1
stem(n, z); % x = n, y = z인 그래프
title('convolution output');