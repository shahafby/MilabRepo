const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});
console.log("Enter a word to rotate:");
rl.on('line', (input) => {
	console.log(input)
	for (let i = input.length - 1; i >0; i--) {
		let first = input.substring(0, i);
		let second = input.substring(i);
		console.log(second + first);
	}
	console.log("Enter a word to rotate:");
});