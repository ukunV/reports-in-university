% uisetcolor
c = uisetcolor('Choose a Color');

% R, G, B separation
myimage = imread('bruno.jpg');

% read each R, G, B as an array
redchannel = myimage(:, :, 1);
bluechannel = myimage(:, :, 2);
greenchannel = myimage(:, :, 3);
graychannel = rgb2gray(myimage);

% Display
figure(1)
subplot(231); imshow(myimage); title('Original image');
subplot(232); imshow(redchannel); title('Red image');
subplot(233); imshow(bluechannel); title('Blue image');
subplot(234); imshow(greenchannel); title('Green image');
subplot(235); imshow(graychannel); title('Gray image');