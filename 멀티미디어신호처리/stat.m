function [mean, stdev, var, err] = stat(x)

% Calculate mean and standard deviation of vector x

[m, n] = size(x); % => [1, 9] : 1차원 9개

mean = sum(x)/n*m;

stdev = sqrt(sum(x.^2)/n*m - mean.^2);

var = stdev^2;

err = stdev / sqrt(n*m);