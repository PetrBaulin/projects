<meta charset="utf-8">
<script>

function getRandomInt(min, max) {
	return Math.floor(Math.random() * (max - min + 1)) + min;
} 


function getCard() {
	var cards = ['6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
	return cards[getRandomInt(0, cards.length - 1)];
} 


function getSum(arr) {
	var sum = 0; 


	for(var i=0; i<arr.length; i++) {
		var card = arr[i];
		if (card != 'A') {
			if (card == 'J' || card == 'Q' || card == 'K') {
				sum = sum + 10;
			} else { 
				sum = sum + parseInt(card);
			}
		}
	} 


	for(var i=0; i<arr.length; i++) {
		var card = arr[i];
		if (card == 'A') {
			if (sum > 10) {
				sum = sum + 1;
			} else {
				sum = sum + 11;
			}
		}
	}
	return sum;
} 


function getStatus() {
	return ' Dealer: ' + dealer.join(' ') + '.' + ' Player: ' + player.join(' ') + '.';
} 


var dealer = [getCard()];
var player = [getCard(), getCard()]; 


if (getSum(player) == 21) {
	alert('Blackjack');
} else {
	var answer = '';
	do {
		answer = prompt(getStatus() + ' Do you want more? type yes or no');


		if(answer == 'yes') {
			player.push(getCard());
			sum = getSum(player);
			if(sum > 21) {
				alert(' busts ' + getStatus());
				break;
			} else if (sum == 21) {
				alert (' Blackjack ' + getStatus());
				break;
			}
		} else {
			while (getSum(dealer) < 17) {
				dealer.push(getCard());

			};

			var sumDealer = getSum(dealer);
			var sumPlayer = getSum(player); 

			if(sumDealer == 21) {
				alert('Dealer has Blackjack ' + getStatus());
			} else if (sumPlayer == sumDealer) {
				alert('tie ' + getStatus());
			} else if (sumDealer > 21) {
				alert('Dealer busts ' + getStatus());
			} else if (sumPlayer > sumDealer) {
				alert('you win ' + getStatus());
			} else {
				alert('you lose ' + getStatus());
			}
		}
	} while(answer == 'yes');
} </script>