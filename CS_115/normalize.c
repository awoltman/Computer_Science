void main()
{
while(1)
{
printf("normal = %\n", normalize(analog(2))); 
msleep(.1);
	}
{
	int MAX_LIGHT =10;
	int MIN_LIGHT =200;
	int output = 100 - ((light - MAX_LIGHT)*100)/(MIN_LIGHT - MAX_LIGHT);
	
	if(output < 0)
		output = 0;
	if(output > 200)
		output = 100;
		
	return output;
}
int LEFT_MOTOR = 0;
int RIGHT_MOTOR = 3;
int RIGHT_EYE = analog(2);
int LEFT_EYE =  analog(3);
	while(1)
	{
		motor(LEFT_MOTOR, normalize(analog(RIGHT_EYE)));
		motor(RIGHT_MOTOR, normalize(analog(LEFT_EYE)));
	}
}
